class Solution {
    public String entityParser(String text) {
        Map<String, Character> entityMap = Map.of(
            "&quot;", '\"',
            "&apos;", '\'',
            "&amp;", '&',
            "&gt;", '>',
            "&lt;", '<',
            "&frasl;", '/'
        );

        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < text.length()) {
            char ch = text.charAt(i);
            if (ch == '&') {
                StringBuilder entity = new StringBuilder();
                entity.append(ch);
                while (ch != ';' && i < text.length() - 1) {
                    ch = text.charAt(++i);
                    if (ch == '&') {
                        res.append(entity.toString());
                        entity = new StringBuilder();
                    }

                    entity.append(ch);
                }
                    
                String entityString = entity.toString();
                if (entityMap.containsKey(entityString)) {
                    res.append(entityMap.get(entityString));
                } else {
                    res.append(entityString);
                }
            } else {
                res.append(ch);
            }
            i++;
        }

        return res.toString();
    }
}
