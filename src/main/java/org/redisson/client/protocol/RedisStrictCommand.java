/**
 * Copyright 2014 Nikita Koksharov, Nickolay Borbit
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
 */
package org.redisson.client.protocol;

import org.redisson.client.protocol.convertor.Convertor;
import org.redisson.client.protocol.decoder.MultiDecoder;

public class RedisStrictCommand<T> extends RedisCommand<T> {

    public RedisStrictCommand(String name, int objectParamIndex, ValueType inParamType) {
        super(name, (Decoder<T>)null, objectParamIndex, inParamType);
    }

    public RedisStrictCommand(String name, MultiDecoder<T> replayMultiDecoder) {
        super(name, replayMultiDecoder);
    }

    public RedisStrictCommand(String name, String subName, MultiDecoder<T> replayMultiDecoder) {
        super(name, subName, replayMultiDecoder, -1);
    }

    public RedisStrictCommand(String name) {
        super(name);
    }

    public RedisStrictCommand(String name, Convertor<T> convertor) {
        super(name, convertor, -1);
    }

    public RedisStrictCommand(String name, Convertor<T> convertor, int encodeParamIndex) {
        super(name, convertor, encodeParamIndex);
    }

    public RedisStrictCommand(String name, String subName, Convertor<T> convertor) {
        super(name, subName, convertor);
    }

    public RedisStrictCommand(String name, String subName, MultiDecoder<T> replayMultiDecoder, Convertor convertor) {
        super(name, subName, replayMultiDecoder, -1);
        this.convertor = convertor;
    }

    public RedisStrictCommand(String name, String subName, Decoder<T> reponseDecoder) {
        super(name, subName, null, reponseDecoder, -1);
    }

    public RedisStrictCommand(String name, Decoder<T> reponseDecoder) {
        super(name, reponseDecoder);
    }

}
