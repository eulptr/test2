public class Main {
    public static void main(String[] args) {
        System.out.println(assertEquals(fN("NAGLIS"), "Naglis"));
        System.out.println(assertEquals(fN("naglis"), "Naglis"));
        System.out.println(assertEquals(fN("nAGLIS"), "Naglis"));
        //System.out.println(assertEquals(fN("NaglisNaglis"), "Naglis"));
        //System.out.println(assertEquals(fN("  Naglisnaglis"), "Naglis"));
        //System.out.println(assertEquals(fN("naglisnaglis  "), "Naglis"));
        System.out.println(assertEquals(fN("Charles marc heRvé perceval"), "Charles Marc Hervé Perceval"));
        System.out.println(assertEquals(fN("Charles marc    heRvé perceval"), "Charles Marc Hervé Perceval"));

    }

    public static String fN(String name) {
        name = name.trim().replaceAll("\\s+", " ").toLowerCase();
        String[] nameParts = name.split(" ");
        String res = "";
        for (int i = 0; i < nameParts.length; i++) {
            res += nameParts[i].substring(0, 1).toUpperCase() + nameParts[i].substring(1) + " ";
        }
        return res.trim();
    }

    public static String formatName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        if (name.substring(0, (name.length() / 2))
                .equalsIgnoreCase(name.substring(name.length() / 2))) {
            name = name.substring(0, (name.length() / 2));
        }
        if (name.contains(" ")) {
            name = Arrays.stream(name.split("\\s+"))
                    .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                    .collect(Collectors.joining(" "));
        }
        return name;//suformatuotas Namecase
    }

    public static boolean assertEquals(String actual, String expected) {
        return actual.equals(expected);
    }
}