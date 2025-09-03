package com.covoro.validationservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoTwo {
    public static void main(String[] args) {

        List<String> list1 = List.of("24220103", "24220104", "24220105", "24220110", "24220111");
        List<String> list2 = List.of("INV-001", "INV-002");
        List<String> list3 = List.of("INV-2025-001", "INV-2025-002");
        List<String> list4 = List.of("INV-FEB-2025-001", "INV-FEB-2025-002");
        List<String> list5 = List.of("2025-INV-001", "2025-INV-002");
        List<String> list6 = List.of("INV-2024-25-001", "INV-2024-25-002");
        List<String> list7 = List.of("INV-MUM-2025-001", "INV-MUM-2025-002");
        List<String> list8 = List.of("INV/DEL/2025/001", "INV/DEL/2025/002");
        List<String> list9 = List.of("CN20240084", "CN20240085");
        List<String> list10 = List.of("INV-00001-25", "INV-00002-25", "INV-00003-25", "INV-00021-25", "INV-00023-25");
        List<String> list11 = List.of("SDDEXP/25-26/10", "SDDEXP/25-26/11");
        System.out.println(findInvoiceSeries(list1));  // [03, 04]
        System.out.println(findInvoiceSeries(list2));  // [001, 002]
        System.out.println(findInvoiceSeries(list3));  // [001, 002]
        System.out.println(findInvoiceSeries(list4));  // [001, 002]
        System.out.println(findInvoiceSeries(list5));  // [001, 002]
        System.out.println(findInvoiceSeries(list6));  // [001, 002]
        System.out.println(findInvoiceSeries(list7));  // [001, 002]
        System.out.println(findInvoiceSeries(list8));  // [001, 002]
        System.out.println(findInvoiceSeries(list9));  // [84, 85]
        System.out.println(findInvoiceSeries(list10)); // [00001, 00002]
        System.out.println(findInvoiceSeries(list11));
        
    }

    private static String longestCommonPrefix(List<String> strings) {
        if (strings == null || strings.isEmpty()) return "";

        String prefix = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            while (!strings.get(i).startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    private static String longestCommonSuffix(List<String> strings) {
        if (strings == null || strings.isEmpty()) return "";

        String suffix = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            while (!strings.get(i).endsWith(suffix)) {
                suffix = suffix.substring(1);
                if (suffix.isEmpty()) return "";
            }
        }
        return suffix;
    }

    public static List<String> findInvoiceSeries(List<String> strings) {
        if (strings == null || strings.isEmpty()) return Collections.emptyList();

        String prefix = longestCommonPrefix(strings);
        String suffix = longestCommonSuffix(strings);

        // Extract numeric core values, while remembering width
        List<Integer> coreNumbers = new ArrayList<>();
        int coreWidth = 0;
        for (String s : strings) {
            int start = prefix.length();
            int end = s.length() - suffix.length();
            String core = s.substring(start, end);
            coreNumbers.add(Integer.parseInt(core));
            coreWidth = core.length(); // record width (assumes same width for all in series)
        }

        List<String> result = new ArrayList<>();

        // Detect continuous ranges
        int startIdx = 0;
        for (int i = 1; i <= coreNumbers.size(); i++) {
            if (i == coreNumbers.size() || coreNumbers.get(i) != coreNumbers.get(i - 1) + 1) {
                int count = i - startIdx;

                String fromCore = String.format("%0" + coreWidth + "d", coreNumbers.get(startIdx));
                String toCore = String.format("%0" + coreWidth + "d", coreNumbers.get(i - 1));

                String from = prefix + fromCore + suffix;
                String to = prefix + toCore + suffix;

                result.add("count " + count + " from " + from + " to " + to);
                startIdx = i;
            }
        }

        return result;
    }
}
