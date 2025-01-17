/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.execution.plan;

import org.gradle.api.Action;
import org.gradle.internal.service.scopes.Scopes;
import org.gradle.internal.service.scopes.ServiceScope;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Collection;

/**
 * Responsible for running the work of a build tree, packaged as zero or more {@link ExecutionPlan} instances.
 */
@ServiceScope(Scopes.BuildTree.class)
@ThreadSafe
public interface PlanExecutor {
    /**
     * Executes an {@link ExecutionPlan}, blocking until complete.
     *
     * @param executionPlan the plan to execute.
     * @param failures collection to collect failures happening during execution into. Does not need to be thread-safe.
     * @param nodeExecutor the actual executor responsible to execute the nodes. Must be thread-safe.
     */
    void process(ExecutionPlan executionPlan, Collection<? super Throwable> failures, Action<Node> nodeExecutor);

    void assertHealthy();
}
