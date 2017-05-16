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

package org.apache.ignite.internal.processors.cache.database.wal;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.internal.pagemem.wal.record.WALRecord;

/**
 * Record serializer.
 */
public interface RecordSerializer {
    /**
     * @return writer
     */
    public int version();

    /**
     * @param record Record.
     * @return Size in bytes.
     */
    public int size(WALRecord record) throws IgniteCheckedException;

    /**
     * @param record Entry to write.
     * @param buf Buffer.
     */
    public void writeRecord(WALRecord record, ByteBuffer buf) throws IgniteCheckedException;

    /**
     * @param in Data input to read data from.
     * @return Read entry.
     */
    public WALRecord readRecord(FileInput in) throws IOException, IgniteCheckedException;
}
