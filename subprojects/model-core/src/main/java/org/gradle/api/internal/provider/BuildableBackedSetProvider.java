/*
 * Copyright 2021 the original author or authors.
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

package org.gradle.api.internal.provider;

import org.gradle.api.Buildable;
import org.gradle.internal.Cast;
import org.gradle.internal.Factory;

import java.util.Set;

public class BuildableBackedSetProvider<T extends Buildable, V> extends BuildableBackedProvider<Set<V>> {

    public BuildableBackedSetProvider(T buildable, Factory<Set<V>> valueFactory) {
        super(buildable, Cast.uncheckedCast(Set.class), valueFactory);
    }
}
