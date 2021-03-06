/*
 * Copyright (c) 2015, Cloudera, Inc. All Rights Reserved.
 *
 * Cloudera, Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"). You may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the
 * License.
 */

package com.cloudera.oryx.app.als;

import com.google.common.math.IntMath;
import org.junit.Test;

import com.cloudera.oryx.common.OryxTest;

public final class ALSUtilsTest extends OryxTest {

  @Test
  public void testImplicitQui() {
    assertTrue(Double.isNaN(ALSUtils.implicitTargetQui(0.0, 1.0)));
    assertTrue(Double.isNaN(ALSUtils.implicitTargetQui(0.0, 0.0)));
    assertTrue(Double.isNaN(ALSUtils.implicitTargetQui(0.0, -1.0)));
    assertTrue(Double.isNaN(ALSUtils.implicitTargetQui(0.5, 1.0)));
    assertTrue(Double.isNaN(ALSUtils.implicitTargetQui(-0.5, 0.0)));
    assertEquals(0.75, ALSUtils.implicitTargetQui(1.0, 0.5));
    assertEquals(0.25, ALSUtils.implicitTargetQui(-1.0, 0.5));
  }

  // Utilities used in ALS-related tests

  /**
   * @param id nonnegative ID
   * @return string like "A0", "B1", ... "A26" ...
   */
  public static String idToStringID(int id) {
    return Character.toString((char) ('A' + IntMath.mod(id, 26))) + Integer.toString(id);
  }

  /**
   * @param stringID string ID like "A0", "B1", etc.
   * @return numeric ID portion 0, 1, etc.
   */
  public static int stringIDtoID(String stringID) {
    return Integer.parseInt(stringID.substring(1));
  }

}
