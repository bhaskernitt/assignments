package com.bhaskerstreet.task2.global;

public final class TestApiResponses {
    private TestApiResponses() {
    }

    public static final String RECORD_NOT_FOUND = "{\n" +
            "  \"httpStatus\": 404,\n" +
            "  \"message\": \"Record does not exist [100]\",\n" +
            "  \"errorUrl\": \"https://bhaskerstreet.com/errors/1002\"\n" +
            "}";

    public static final String GET_RECORDS = "[\n" +
            "  {\n" +
            "    \"Name\": \"Warrior\",\n" +
            "    \"Sub Classes\": [\n" +
            "      {\n" +
            "        \"Name\": \"Fighter\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Paladin\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ranger\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Wizard\",\n" +
            "    \"Sub Classes\": [\n" +
            "      {\n" +
            "        \"Name\": \"Mage\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Specialist wizard\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Priest\",\n" +
            "    \"Sub Classes\": [\n" +
            "      {\n" +
            "        \"Name\": \"Cleric\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Druid\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Priest of specific mythos\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Name\": \"Rogue\",\n" +
            "    \"Sub Classes\": [\n" +
            "      {\n" +
            "        \"Name\": \"Thief\",\n" +
            "        \"Sub Classes\": [\n" +
            "          {\n" +
            "            \"Name\": \"Assassin\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Bard\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";


    public static final String RECORD_BY_ID_1 = "{\n" +
            "  \"Name\": \"Warrior\",\n" +
            "  \"Sub Classes\": [\n" +
            "    {\n" +
            "      \"Name\": \"Fighter\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Name\": \"Paladin\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Name\": \"Ranger\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String RECORD_BY_ID_2 = "{\n" +
            "  \"Name\": \"Wizard\",\n" +
            "  \"Sub Classes\": [\n" +
            "    {\n" +
            "      \"Name\": \"Mage\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Name\": \"Specialist wizard\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String RECORD_BY_ID_3 = "{\n" +
            "  \"Name\": \"Priest\",\n" +
            "  \"Sub Classes\": [\n" +
            "    {\n" +
            "      \"Name\": \"Cleric\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Name\": \"Druid\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Name\": \"Priest of specific mythos\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String RECORD_BY_ID_4 = "{\n" +
            "  \"Name\": \"Rogue\",\n" +
            "  \"Sub Classes\": [\n" +
            "    {\n" +
            "      \"Name\": \"Thief\",\n" +
            "      \"Sub Classes\": [\n" +
            "        {\n" +
            "          \"Name\": \"Assassin\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"Name\": \"Bard\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String RECORD_BY_ID_5 = "{\n" +
            "  \"Name\": \"Fighter\"\n" +
            "}";
}
