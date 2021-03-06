/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kalix.fabric8.redis;

import redis.clients.jedis.Jedis;

public class MyServiceImpl implements MyService {
    private String serviceName; //configMap
    private String secretValue;
    private String url;
    private Jedis jedis;
    public String echo(String message) {
        return this.serviceName + message;
    }

    public void init(){
        jedis=JedisFactory.getInstance().getJedisPool().getResource();
        jedis.set("key", "Hello, Redis!");
        System.out.println("key = " + jedis.get("key"));
        jedis.del("key");
        System.out.println("key = " + jedis.get("key"));
        JedisFactory.getInstance().getJedisPool().close();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecretValue() {
        return secretValue;
    }

    public void setSecretValue(String secretValue) {
        this.secretValue = secretValue;
    }
}