/*
 * Copyright (c) 2022 Jonathan Schnieders. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 3 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.jonathanschnieders.datastructs;

import com.jonathanschnieders.datastructs.JArrayList;

public class JQueue<T extends Object> {
  private JArrayList<T> data;
  
  public JQueue() {
    data = new JArrayList<>();
  }
  
  public void enqueue(T pObject) {
    this.data.add(pObject);
  }
  
  public void enqueue() {
    this.data.remove(0);
  }
  
  public T peek(int pIndex) {
    return this.data.get(pIndex);
  }
  
  public int size() {
    return this.data.getSize();
  }
  
  public boolean isEmpty() {
    return this.data.isEmpty();
  }
  
  public void poll() {
    this.data.print();
  }
}
