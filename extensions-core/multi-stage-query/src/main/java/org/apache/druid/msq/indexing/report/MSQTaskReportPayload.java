/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.druid.msq.indexing.report;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.druid.msq.counters.CounterSnapshotsTree;

import javax.annotation.Nullable;

public class MSQTaskReportPayload
{
  public static final String FIELD_STATUS = "status";
  public static final String FIELD_STAGES = "stages";
  public static final String FIELD_COUNTERS = "counters";
  public static final String FIELD_RESULTS = "results";

  private final MSQStatusReport status;

  @Nullable
  private final MSQStagesReport stages;

  @Nullable
  private final CounterSnapshotsTree counters;

  @Nullable
  private final MSQResultsReport results;

  @JsonCreator
  public MSQTaskReportPayload(
      @JsonProperty(FIELD_STATUS) MSQStatusReport status,
      @JsonProperty(FIELD_STAGES) @Nullable MSQStagesReport stages,
      @JsonProperty(FIELD_COUNTERS) @Nullable CounterSnapshotsTree counters,
      @JsonProperty(FIELD_RESULTS) @Nullable MSQResultsReport results
  )
  {
    this.status = status;
    this.stages = stages;
    this.counters = counters;
    this.results = results;
  }

  @JsonProperty
  public MSQStatusReport getStatus()
  {
    return status;
  }

  @Nullable
  @JsonProperty
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public MSQStagesReport getStages()
  {
    return stages;
  }

  @Nullable
  @JsonProperty
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public CounterSnapshotsTree getCounters()
  {
    return counters;
  }

  @Nullable
  @JsonProperty
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public MSQResultsReport getResults()
  {
    return results;
  }
}
