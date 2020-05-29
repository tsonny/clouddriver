/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.clouddriver.aws.provider.agent;

import com.netflix.spinnaker.clouddriver.aws.agent.CatsClusterCachingAgent;
import com.netflix.spinnaker.clouddriver.aws.data.Keys;
import com.netflix.spinnaker.clouddriver.aws.provider.AwsProvider;

public class AmazonAuthoritativeClustersAgent extends CatsClusterCachingAgent {

  public AmazonAuthoritativeClustersAgent() {
    super(
        Keys.getServerGroupKey("*", "*", "*", "*"),
        Keys::parse,
        sg -> Keys.getClusterKey(sg.get("cluster"), sg.get("application"), sg.get("account")));
  }

  @Override
  public String getAgentType() {
    return getClass().getSimpleName();
  }

  @Override
  public String getProviderName() {
    return AwsProvider.PROVIDER_NAME;
  }
}