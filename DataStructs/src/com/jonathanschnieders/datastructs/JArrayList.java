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

import java.lang.reflect.Array;

public class JArrayList<T extends Object> {
    private T[] arr;
    private T[] cash;
    
    private int size = 0;
    
    
    public JArrayList() {
        arr = (T[]) Array.newInstance(Object.class, 0);
        this.arr = arr;
    }
    
    public void add(T pIn) {
        int len = arr.length;
        
        cash = (T[]) Array.newInstance(Object.class, len+1);
        
        int index = 0;
        
        for (T element : arr) {
            cash[index++] = element;
        }
        
        cash[index] = pIn;
        arr = cash;
        
        this.arr = arr;
        this.size = arr.length;
    }
    
    public T get(int pIndex) {
        return (this.arr[pIndex]);
    }
    
    
    public T[] toArray() {
        return (this.arr);
    }
    
    public int getSize() {
        return (this.arr.length);
    }
  
    public int size() {
        return (this.arr.length);
    }
    
    public void remove(int pIndex) {
        int len = arr.length;
        
        if (pIndex > len-1 || pIndex < 0) {System.out.println("Index out of bound!");}
        if (len == 0) {System.out.println("List already empty");}
        
        cash = (T[]) Array.newInstance(Object.class, len-1);
        
        
        int index = 0;
        
        for (T element : arr) {
            if (index != pIndex) {cash[index++] = element;}
        }
        
        arr = cash;
        
        this.arr = arr;
        this.size = arr.length;
    }
    
    public void remove(Object pObject) {
        int len = arr.length;
        
        if (len == 0) {System.out.println("List already empty");}
        
        cash = (T[]) Array.newInstance(Object.class, len-1);
        
        
        int index = 0;
        
        //Out of bound catch if object is not in list
        
        for (T element : arr) {
            if (element != pObject) {cash[index++] = element;}
        }
        
        arr = cash;
        
        this.arr = arr;
        this.size = arr.length;
    }
    
    public void clear() {
        int len = arr.length;
        
        if (len == 0) {System.out.println("List already empty");}
         
        this.size = 0;
        this.arr = (T[]) Array.newInstance(Object.class, 0);
        
        arr = this.arr;
        cash = null;
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public int indexOf(T pObject) {
        int index = 0;
        
        for (T element : arr) {
            if (element == pObject) {return index;}
            index++;
        }
        
        return 0;
    }

    public int lastIndexOf(T pObject) {
        int index = 0;
        int lastIndex = 0;
        
        for (T element : arr) {
            if (element == pObject) {lastIndex = index;}
            index++;
        }
        
        return lastIndex;
    }

    public boolean containsAll(JArrayList<T> pList) {
        int index = 0;
        
        for (T element : pList.toArray()) {
            if (element != arr[index]) {return false;}
            index++;
        }
        
        return true;
    }

    //Metohd to sort the list using bubble sort
    public void sort() {
        int len = arr.length;
        
        if (len == 0) {
            System.out.println("List is empty! Nothing to sort.");
        }
        else {
            try {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len-i-1; j++) {
                        String c1 = (String) arr[j];
                        String c2 = (String) arr[j+1];
                        
                        
                        if (c1.compareTo(c2) > 0) {
                            T temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                        }
                    }
                    
                    this.arr = arr;
                }
            }
            catch(ClassCastException e) {
                System.out.println("List can only be sorted if it contains a comparable object.");
            }
            
            /*if (arr[0] instanceOf Number) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len-i-1; j++) {
                        if (arr[j] > arr[j+1]) {
                            T temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                        }
                    }
                }
            }
            else if (arr[0] instanceOf String) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len-i-1; j++) {
                        if (arr[j].compareTo(arr[j+1]) > 0) {
                            T temp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = temp;
                        }
                    }
                }
            }
            else {
                System.out.println("List can only be sorted if it contains numbers or strings.");
            }*/
        }

        /*for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (arr[j].toString().compareTo(arr[j+1].toString()) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }*/
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    public boolean contains(T pObject) {
        for (T element : arr) {
            if (element == pObject) {return true;}
        }
        
        return false;
    }

    public void print() {
        for (T element : arr) {
            System.out.println(element);
        }
    }

    public static void main(String []args){
        System.out.println(" ----- JArrayList Module -----");
        System.out.println("(c) Jonathan Schnieders, 2022");
        System.out.println("----------------------------- \n");
        
        //Testing
        /*
        JArrayList<String> test = new JArrayList<>();
        
        if (test.isEmpty()) System.out.println("Leer");
        
        test.add("Hello ");
        test.add("World");
        
        System.out.println(test.get(0) + test.get(1));
        
        if (!(test.isEmpty())) System.out.println("Gefuellt");
        
        test.remove(1);
        test.add("World!");
        
        System.out.println(test.get(0) + test.get(1));
        
        test.clear();
        if (test.isEmpty()) System.out.println("Leer");
        
        test.add("Tset");
        test.set(0, "Test");
        
        System.out.println(test.get(0));
        
        test.remove("Test");
        if (test.isEmpty()) System.out.println("Leer");
        
        test.add("C");
        test.add("B");
        test.add("A");
        
        test.sort();
        
        test.print();
        */
    }
}
