package hexlet.code.formatters;

public class Stylish implements Format {
    @Override
    public final String packer(String string) {
        return "{\n" + string + "}";
    }

    @Override
    public final String buildString(String status, String key, Object lastValue, Object value) {
        StringBuilder sb = new StringBuilder();
        switch (status) {
            case "changed" -> {
                sb.append("  - ").append(key).append(": ").append(transformToString(lastValue)).append("\n");
                sb.append("  + ").append(key).append(": ").append(transformToString(value)).append("\n");
            }
            case "unchanged" -> sb.append("    ").append(key).append(": ").append(transformToString(value))
                    .append("\n");
            case "added" -> sb.append("  + ").append(key).append(": ").append(transformToString(value))
                    .append("\n");
            default -> sb.append("  - ").append(key).append(": ").append(transformToString(lastValue))
                    .append("\n");
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
