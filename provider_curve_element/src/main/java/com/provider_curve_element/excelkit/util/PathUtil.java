/*
 * Copyright (c) 2018, 吴汶泽 (wenzewoo@gmail.com).
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.provider_curve_element.excelkit.util;

import java.io.File;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author wuwenze
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PathUtil {

  public static String getClasspath() {
    return PathUtil.class.getResource("/").getPath();
  }

  public static String getFilePathByClasspath(String name) {
    return PathUtil.getClasspath() + name;
  }

  public static File getFileByClasspath(String name) {
    return new File(PathUtil.getFilePathByClasspath(name));
  }
}