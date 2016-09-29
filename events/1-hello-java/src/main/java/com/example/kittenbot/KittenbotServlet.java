/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.kittenbot;

import com.google.common.io.CharStreams;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class KittenbotServlet extends HttpServlet {

  // TODO: add doGet with add-to-Slack button.

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
    String json = CharStreams.toString(req.getReader());
    Event event = gson.fromJson(json, Event.class);
    String type = event.getType();

    if ("url_verification".equals(type)) {
      handleUrlVerification(resp, gson.fromJson(json, UrlVerificationEvent.class));
    } else if ("event_callback".equals(type)) {
      handleEventCallback(resp, gson.fromJson(json, EventCallback.class));
    } else {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Can't handle event type: " + type);
    }
  }

  private static void handleEventCallback(HttpServletResponse resp, EventCallback envelope)
      throws IOException {
    String token = System.getenv("SLACK_TOKEN");

    if (!token.equals(envelope.getToken())) {
      resp.sendError(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

  }

  private static void handleUrlVerification(HttpServletResponse resp, UrlVerificationEvent event)
      throws IOException {
    String token = System.getenv("SLACK_TOKEN");

    if (!token.equals(event.getToken())) {
      resp.sendError(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    resp.setContentType("plain/text");
    PrintWriter out = resp.getWriter();
    out.println(event.getChallenge());
  }
}
