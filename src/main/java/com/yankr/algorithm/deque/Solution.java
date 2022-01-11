package com.yankr.algorithm.deque;

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String cmdSize = reader.readLine();
            String  dequeSize = reader.readLine();
            DequeSelf deque = new DequeSelf(Integer.parseInt(dequeSize));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("push_back")) {
                    deque.push_back(Short.parseShort(line.split("\\s")[1]));
                }
                if (line.contains("push_front")) {
                    deque.push_front(Short.parseShort(line.split("\\s")[1]));
                }
                if (line.contains("pop_front")) {
                    deque.pop_front();
                }
                if (line.contains("pop_back")) {
                    deque.pop_back();
                }
            }
        }
    }

    public static class DequeSelf {

        private final String ERROR = "error";
        private int maxSize;
        private short[] queArr;
        private int frontIdx;
        private int rearIdx;
        private int eIdx;

        public DequeSelf(int size) {
            this.maxSize = size;
            this.queArr = new short[size];
            this.frontIdx = -1;
            this.rearIdx = -1;
            this.eIdx = 0;
        }

        public boolean isFull() {
            return eIdx == maxSize;
        }

        public boolean isEmpty() {
            return eIdx == 0;
        }

        public void push_front(short value) {
            if (isFull()) {
                System.out.println(ERROR);
            } else {
                if (frontIdx < 0) {
                    frontIdx = maxSize - 1;
                }
                queArr[frontIdx--] = value;
                eIdx++;
            }
        }

        public void pop_front() {
            if (isEmpty()) {
                System.out.println(ERROR);
            } else {
                if (frontIdx == maxSize - 1) {
                    frontIdx = -1;
                }
                int tmp = queArr[++frontIdx];
                System.out.println(tmp);
                eIdx--;
            }
        }

        public void push_back(short value) {
            if (isFull()) {
                System.out.println(ERROR);
            } else {
                if (rearIdx == maxSize - 1) {
                    rearIdx = -1;
                }
                queArr[++rearIdx] = value;
                eIdx++;
            }
        }

        public void pop_back() {
            if (isEmpty()) {
                System.out.println(ERROR);
            } else {
                if (rearIdx < 0) {
                    rearIdx = maxSize - 1;
                }
                int tmp = queArr[rearIdx--];
                System.out.println(tmp);
                eIdx--;
            }
        }
    }
}