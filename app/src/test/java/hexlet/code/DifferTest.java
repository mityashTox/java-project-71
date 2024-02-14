package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    @Test
    void fileNotExistTest() {
        String testFilePath1 = "src/test/resources/files/file0.json";
        String testFilePath2 = "src/test/resources/files/file2.json";
        String expected = "File 'src/test/resources/files/file0.json' cannot be reading";
        assertThat(Differ.generate(testFilePath1, testFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    void generatePlainTest() {
        String testFilePath1 = "src/test/resources/files/file3.json";
        String testFilePath2 = "src/test/resources/files/file4.json";
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        assertThat(Differ.generate(testFilePath1, testFilePath2, "plain")).isEqualTo(expected);
    }

    @Test
    void generateStylishTest() {
        String testFilePath1 = "src/test/resources/files/file3.json";
        String testFilePath2 = "src/test/resources/files/file4.json";
        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertThat(Differ.generate(testFilePath1, testFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    void generateJsonTest() {
        String testFilePath1 = "src/test/resources/files/file3.json";
        String testFilePath2 = "src/test/resources/files/file4.json";
        String expected = "{\"chars1\":\"[a, b, c]\",\"- chars2\":\"[d, e, f]\",\""
                + "+ chars2\":\"false\",\"- checked\":\"false\",\"+ checked\":\"true\",\"- default\":\"null\",\""
                + "+ default\":\"[value1, value2]\",\"- id\":\"45\",\"+ id\":\"null\",\"- key1\":\"value1\",\""
                + "+ key2\":\"value2\",\"numbers1\":\"[1, 2, 3, 4]\",\"- numbers2\":\"[2, 3, 4, 5]\",\""
                + "+ numbers2\":\"[22, 33, 44, 55]\",\"- numbers3\":\"[3, 4, 5]\",\"+ numbers4\":\"[4, 5, 6]\",\""
                + "+ obj1\":\"{nestedKey=value, isNested=true}\",\"- setting1\":\"Some value\",\""
                + "+ setting1\":\"Another value\",\"- setting2\":\"200\","
                + "\"+ setting2\":\"300\",\"- setting3\":\"true\",\"+ setting3\":\"none\"}";
        assertThat(Differ.generate(testFilePath1, testFilePath2, "json")).isEqualTo(expected);
    }
}
