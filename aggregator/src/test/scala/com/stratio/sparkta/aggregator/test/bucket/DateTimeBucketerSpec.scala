/**
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.sparkta.aggregator.test.bucket

import java.io
import java.util.Date

import com.stratio.sparkta.aggregator.bucket
import com.stratio.sparkta.aggregator.bucket.DateTimeBucketer
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, Matchers, WordSpecLike}

/**
 * Created by ajnavarro on 9/10/14.
 */
class DateTimeBucketerSpec extends WordSpecLike with Matchers with BeforeAndAfter with BeforeAndAfterAll {
  var dateTimeBucketer: DateTimeBucketer = null
  before {
    dateTimeBucketer = new DateTimeBucketer()
  }

  after {
    dateTimeBucketer = null
  }

  "A DateTimeBucketer" should {
    "In default implementation, get 5 buckets for a specific time" in {
      val newDate = new Date()
      val buckets = dateTimeBucketer.bucketForWrite(newDate.asInstanceOf[io.Serializable])

      buckets.size should be(5)

      buckets.keys should contain(bucket.DateTimeBucketer.minutes)
      buckets.keys should contain(bucket.DateTimeBucketer.hours)
      buckets.keys should contain(bucket.DateTimeBucketer.days)
      buckets.keys should contain(bucket.DateTimeBucketer.months)
      buckets.keys should contain(bucket.DateTimeBucketer.years)
    }
  }
}
