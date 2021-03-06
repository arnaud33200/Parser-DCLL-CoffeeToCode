/*
 * Copyright 2013 Tsaap Development Group
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

package org.tsaap.questions;

import java.io.IOException;
import java.io.Reader;

/**
 * @author franck Silvestre
 */
public interface QuizReader {
    /**
     * Parse an input source describing a quiz.
     * @param reader
     *            the input source
     * @throws IOException the IOException
     * @throws QuizReaderException the IOException
     */
    void parse(Reader reader) throws IOException, QuizReaderException;

    /**
     * Get the quiz content handler that is notified during the parsing. Design
     * inspired from SAX API.
     * @return the quiz content handler
     */
    QuizContentHandler getQuizContentHandler();
}
