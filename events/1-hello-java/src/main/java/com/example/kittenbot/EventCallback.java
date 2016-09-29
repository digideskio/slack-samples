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

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * The envelope for an event from the Slack Events API.
 *
 * <p>See: https://api.slack.com/events-api#receiving_events
 */
public class EventCallback extends Event {
  private String token;
  private String teamId;
  private String apiAppId;
  private Event event;
  private String eventTs;
  private List<String> authedUsers;

  public EventCallback() {
    authedUsers = ImmutableList.of();
  }

  public String getToken() {
    return token;
  }

  public String getTeamId() {
    return teamId;
  }

  public String getApiAppId() {
    return apiAppId;
  }

  public Event getEvent() {
    return event;
  }

  public String getEventTs() {
    return eventTs;
  }

  public ImmutableList<String> getAuthedUsers() {
    return ImmutableList.copyOf(authedUsers);
  }
}
