/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/ 
package application.rest;

import com.google.common.base.MoreObjects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.google.common.base.MoreObjects.firstNonNull;

@ApplicationPath("rest")
@Path("/")
public class LibertyRestEndpoint extends Application {

    @Context
    private HttpServletRequest request;

    @GET
    @Path("/")
    public String hello() {
        HttpSession session = request.getSession();
        Integer count = 0;
        String host = "";
        try {
            host =  firstNonNull((String)session.getAttribute("Host"),"");
            session.setAttribute("Host", InetAddress.getLocalHost().getHostName());
            count = firstNonNull((Integer)session.getAttribute("Count"),0);
            count++;
            session.setAttribute("Count", count);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "Hello from the REST endpoint! Count:" + count.toString() + " last request   from:" + host ;
    }

}