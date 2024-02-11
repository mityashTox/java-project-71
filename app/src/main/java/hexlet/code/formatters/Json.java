package hexlet.code.formatters;

public class Json implements Format {
    @Override
    public final String packer(String string) {
        return "{" + string.substring(0, string.length() - 1) + "}";
    }

    @Override
    public final String buildString(String status, String key, Object lastValue, Object value) {
        StringBuilder sb = new StringBuilder();
        switch (status) {
            case "changed" -> {
                sb.append("\"- ").append(key).append("\":\"").append(transformToString(lastValue)).append("\",");
                sb.append("\"+ ").append(key).append("\":\"").append(transformToString(value)).append("\",");
            }
            case "unchanged" -> sb.append("\"").append(key).append("\":\"").append(transformToString(value))
                    .append("\",");
            case "added" -> sb.append("\"+ ").append(key).append("\":\"").append(transformToString(value))
                    .append("\",");
            default -> sb.append("\"- ").append(key).append("\":\"").append(transformToString(lastValue))
                    .append("\",");
        }
        return sb.toString();
    }

    @Override
    public final String transformToString(Object o) {
        String result;
        if (o == null) {
            result = "null";
        } else {
            result = o.toString();
        }
        return result;
    }
}
