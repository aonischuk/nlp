/*
 *  Copyright © 2019 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.cdap.google.common;

import com.google.cloud.language.v1.AnalyzeEntitySentimentRequest;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.protobuf.MessageOrBuilder;

/**
 * Sentiment analysis will provide the prevailing emotional opinion within a provided text. The API returns two values:
 * The "score" describes the emotional leaning of the text from -1 (negative) to +1 (positive), with 0 being neutral.
 *
 * The "magnitude" measures the strength of the emotion.
 */
public class AnalyzeEntitySentiment extends NLPMethodExecutor {

  public AnalyzeEntitySentiment(String languageCode, EncodingType encoding, LanguageServiceClient language) {
    super(languageCode, encoding, language);
  }

  @Override
  public MessageOrBuilder executeRequest(LanguageServiceClient language, Document document) {
    AnalyzeEntitySentimentRequest request = AnalyzeEntitySentimentRequest.newBuilder()
      .setDocument(document)
      .setEncodingType(encoding)
      .build();

    return language.analyzeEntitySentiment(request);
  }
}

