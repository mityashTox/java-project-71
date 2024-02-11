package hexlet.code.formatters;

public class Plain implements Format {
    @Override
    public final String packer(String string) {
        return string.substring(0, string.length() - 1);
    }

    @Override
    public final String buildString(String status, String key, Object lastValue, Object value) {
        StringBuilder sb = new StringBuilder();
        switch (status) {
            case "changed" -> {
                sb.append("Property '").append(key).append("' was updated. From ")
                        .append(transformToString(lastValue)).append(" to ").append(transformToString(value))
                        .append("\n");
            }
            case "unchanged" -> {
            }
            case "added" -> sb.append("Property '").append(key).append("' was added with value: ")
                    .append(transformToString(value)).append("\n");
            default -> sb.append("Property '").append(key).append("' was removed").append("\n");
        }
        return sb.toString();
    }

    @Override
    public final String transformToString(Object o) {
        String result;
        if (o == null) {
            result = "null";
        } else if (o instanceof String) {
            result = "'" + o + "'";
        } else if (o instanceof Integer
                || o instanceof Boolean
                || o instanceof Character) {
            result = o.toString();
        } else {
            result = "[complex value]";
        }
        return result;
    }
}
