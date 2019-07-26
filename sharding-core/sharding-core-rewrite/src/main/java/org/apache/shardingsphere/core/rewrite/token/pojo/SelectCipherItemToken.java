/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.rewrite.token.pojo;

import com.google.common.base.Strings;
import lombok.Getter;

/**
 * Insert cipher item token.
 *
 * @author panjuan
 */
@Getter
public final class SelectCipherItemToken extends SQLToken implements Substitutable {
    
    private final int stopIndex;
    
    private final String selectItemName;
    
    private final String alias;
    
    public SelectCipherItemToken(final int startIndex, final int stopIndex, final String selectItemName, final String alias) {
        super(startIndex);
        this.stopIndex = stopIndex;
        this.selectItemName = selectItemName;
        this.alias = alias;
    }
    
    @Override
    public String toString() {
        return Strings.isNullOrEmpty(alias) ? selectItemName : String.format("%s AS %s", selectItemName, alias);
    }
}
