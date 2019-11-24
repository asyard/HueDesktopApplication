package org.yardimci.hue.core;

import org.yardimci.hue.config.HueAppSettings;
import org.yardimci.hue.core.model.Bridge;
import org.yardimci.hue.core.model.response.LightResponse;
import org.yardimci.hue.core.model.response.LightResponseData;
import org.yardimci.hue.core.model.response.lamp.Lamp;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.yardimci.hue.util.Util.getNotNullValue;

public class HueConnection {

    private Client client;
    private Bridge bridge;
    private boolean isConnected = false;

    private static HueConnection instance;

    public static HueConnection getInstance() {
        if (instance == null) {
            instance = new HueConnection();
        }
        return instance;
    }

    public boolean connect() {
        if (isConnected) {
            return true;
        }

        try {
            //todo
            client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("https://discovery.meethue.com/"); //response:[{"id":"ecb5fafffe24592d","internalipaddress":"192.168.0.22"}]
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
            Response response = invocationBuilder.get();
            if (response == null || response.getStatus() != 200) {
                System.out.println("response is empty or not valid");
                return false;
            }

            List bridgeList = response.readEntity(ArrayList.class);

            if (bridgeList == null || bridgeList.isEmpty()) {
                System.out.println("no bridge found"); //todo
                return false;
            } else if(bridgeList.size() > 1) {
                System.out.println("more than one bridge found. Using first one"); //todo
            }

            LinkedHashMap bridgeMap = (LinkedHashMap) bridgeList.get(0);
            bridge = new Bridge(getNotNullValue(bridgeMap.get("id")), getNotNullValue(bridgeMap.get("internalipaddress")),
                    getNotNullValue(bridgeMap.get("macaddress")), getNotNullValue(bridgeMap.get("name")));
            System.out.println(bridge);


        } catch (Exception e) {
            e.printStackTrace(); //todo log
            return false;
        }
        isConnected = true;
        return true;
    }

    public List<Lamp> listLamps() throws Exception {
        List<Lamp> lampList = new ArrayList<>();
        if (!isConnected) {
            //boolean connectResult = connect();
            //if (!connectResult) {
                //throw new Exception("error.connectionfailed");
            //}
            throw new Exception("error.notconnected");
        }

        try {
            WebTarget webTarget = client.target("http://"+ getBridge().getInternalipaddress()).path("api").path(HueAppSettings.getInstance().getAppId());

            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
            Response response = invocationBuilder.get();
            if (response == null || response.getStatus() != 200) {
                System.out.println("Response is empty or not valid");
                throw new Exception("error.responseisnotvalid");
            }

            LightResponse lampListResultList = response.readEntity(LightResponse.class);
            System.out.println(lampListResultList);
            /*if (lampListResultList == null || lampListResultList.isEmpty()) {
                System.out.println("result is empty");
                return lampList;
            }*/

            /*Iterator iterator = lampListResultList.iterator();
            while (iterator.hasNext()) {
                try {
                    LinkedHashMap lampMap = (LinkedHashMap) iterator.next();
                    System.out.println(lampMap);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/
            LightResponseData lights = lampListResultList.getLights();
            if (lights.getLamp1() != null) {
                lampList.add(lights.getLamp1());
            }
            if (lights.getLamp2() != null) {
                lampList.add(lights.getLamp2());
            }
            if (lights.getLamp3() != null) {
                lampList.add(lights.getLamp3());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("error.unabletolistlamps");
        }
        return lampList;
    }

    public boolean createAppId() {
        if (HueAppSettings.getInstance().getAppId() != null && !HueAppSettings.getInstance().getAppId().isEmpty()) {
            return true;
        }

        if (!isConnected) {
            boolean connectResult = connect();
            if (!connectResult) {
                return false; //todo connection failed
            }
        }

        try {
            WebTarget webTarget = client.target("http://"+ getBridge().getInternalipaddress()).path("api");

            String postString = "{\"devicetype\":\"HueDesktopApplication#v1\"}"; // todo

            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
            Response response = invocationBuilder.post(Entity.entity(postString, MediaType.APPLICATION_XML));
            if (response == null || response.getStatus() != 200) {
                System.out.println("Response is empty or not valid");
                return false;
            }

            List appIdCreateResultList = response.readEntity(ArrayList.class);
            if (appIdCreateResultList == null || appIdCreateResultList.isEmpty()) {
                System.out.println("result is empty");
                return false;
            }

            LinkedHashMap appIdResult = (LinkedHashMap) appIdCreateResultList.get(0);
            if (appIdResult.get("error") != null) {
                System.out.println("error : " + appIdResult.get("error"));
                return false;
            }

            if (appIdResult.get("success") != null) {
                LinkedHashMap successResultMap = (LinkedHashMap) appIdResult.get("success");
                String appId = successResultMap.get("username").toString();
                System.out.println("app id :" + appId);
                HueAppSettings.getInstance().setAppId(appId);
                HueAppSettings.getInstance().applySettings();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public Bridge getBridge() {
        return bridge;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean disconnect() {
        if (!isConnected) {
            return true;
        }

        //todo
        isConnected = false;
        return true;
    }
}
