package com.manish.interview.test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class JsonParserClient {
    public static void main(String[] args) throws JsonProcessingException {
        String strjson = "{\n" +
                "    \"definition\": {\n" +
                "        \"$schema\": \"https://schema.management.azure.com/providers/Microsoft.Logic/schemas/2016-06-01/workflowdefinition.json#\",\n" +
                "        \"actions\": {\n" +
                "            \"HTTP\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"method\": \"GET\",\n" +
                "                    \"uri\": \"https://www.google.com\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"HTTP_2\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"Http\"\n" +
                "            },\n" +
                "            \"HTTP_2\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"method\": \"GET\",\n" +
                "                    \"uri\": \"https://www.linkedin.com\"\n" +
                "                },\n" +
                "                \"runAfter\": {},\n" +
                "                \"type\": \"Http\"\n" +
                "            },\n" +
                "            \"Bulk_Import\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"body\": {\n" +
                "                        \"id\": \"@variables('jobId')\",\n" +
                "                        \"ready_to_execute\": true\n" +
                "                    },\n" +
                "                    \"host\": {\n" +
                "                        \"connection\": {\n" +
                "                            \"name\": \"@parameters('$connections')['Harmony-Salesloft']['connectionId']\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"method\": \"put\",\n" +
                "                    \"path\": \"/v2/bulk_jobs/@{encodeURIComponent(variables('jobId'))}\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Complete_the_message_in_a_topic_subscription\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"ApiConnection\"\n" +
                "            },\n" +
                "            \"Complete_the_message_in_a_topic_subscription\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"host\": {\n" +
                "                        \"connection\": {\n" +
                "                            \"name\": \"@parameters('$connections')['servicebus_1']['connectionId']\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"method\": \"delete\",\n" +
                "                    \"path\": \"/@{encodeURIComponent(encodeURIComponent('tagee-salesloftlmstop'))}/subscriptions/@{encodeURIComponent('salesloftlmstopicsubscription')}/messages/complete\",\n" +
                "                    \"queries\": {\n" +
                "                        \"lockToken\": \"@triggerBody()?['LockToken']\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Upload_Records\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"ApiConnection\"\n" +
                "            },\n" +
                "            \"Init_JobState\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"variables\": [\n" +
                "                        {\n" +
                "                            \"name\": \"Jobstate\",\n" +
                "                            \"type\": \"string\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Init_jobId\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"InitializeVariable\"\n" +
                "            },\n" +
                "            \"Init_isDone\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"variables\": [\n" +
                "                        {\n" +
                "                            \"name\": \"isDone\",\n" +
                "                            \"type\": \"boolean\",\n" +
                "                            \"value\": \"@false\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"runAfter\": {},\n" +
                "                \"type\": \"InitializeVariable\"\n" +
                "            },\n" +
                "            \"Init_jobId\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"variables\": [\n" +
                "                        {\n" +
                "                            \"name\": \"jobId\",\n" +
                "                            \"type\": \"integer\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Init_isDone\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"InitializeVariable\"\n" +
                "            },\n" +
                "            \"Initialize_Bulk_Upload\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"body\": {\n" +
                "                        \"type\": \"crm_share/upsert\"\n" +
                "                    },\n" +
                "                    \"host\": {\n" +
                "                        \"connection\": {\n" +
                "                            \"name\": \"@parameters('$connections')['Harmony-Salesloft']['connectionId']\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"method\": \"post\",\n" +
                "                    \"path\": \"/v2/bulk_jobs\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Init_JobState\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"ApiConnection\"\n" +
                "            },\n" +
                "            \"Send_message\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"body\": {\n" +
                "                        \"ContentData\": \"@{base64(concat('{\\\"jobid\\\":',variables('jobId'),'}'))}\",\n" +
                "                        \"ContentType\": \"application/json\"\n" +
                "                    },\n" +
                "                    \"host\": {\n" +
                "                        \"connection\": {\n" +
                "                            \"name\": \"@parameters('$connections')['servicebus_1']['connectionId']\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"method\": \"post\",\n" +
                "                    \"path\": \"/@{encodeURIComponent(encodeURIComponent('tagee-asslltopsfoetlm'))}/messages\",\n" +
                "                    \"queries\": {\n" +
                "                        \"systemProperties\": \"None\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Wait_Untill_the_Bulk_Import_Is_Completed\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"ApiConnection\"\n" +
                "            },\n" +
                "            \"Set_JobState\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"name\": \"Jobstate\",\n" +
                "                    \"value\": \"@{body('Bulk_Import')['data']['state']}\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Bulk_Import\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"SetVariable\"\n" +
                "            },\n" +
                "            \"Set_jobId\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"name\": \"jobId\",\n" +
                "                    \"value\": \"@body('Initialize_Bulk_Upload')['data']['id']\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Initialize_Bulk_Upload\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"SetVariable\"\n" +
                "            },\n" +
                "            \"Upload_Records\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"body\": \"@base64ToString(triggerBody()?['ContentData'])\",\n" +
                "                    \"headers\": {\n" +
                "                        \"Content-Type\": \" application/json\"\n" +
                "                    },\n" +
                "                    \"host\": {\n" +
                "                        \"connection\": {\n" +
                "                            \"name\": \"@parameters('$connections')['Harmony-Salesloft']['connectionId']\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"method\": \"post\",\n" +
                "                    \"path\": \"/v2/bulk_jobs/@{encodeURIComponent(variables('jobId'))}/job_data\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Set_jobId\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"ApiConnection\"\n" +
                "            },\n" +
                "            \"Wait_Untill_the_Bulk_Import_Is_Completed\": {\n" +
                "                \"actions\": {\n" +
                "                    \"Bulk_Import_Status\": {\n" +
                "                        \"inputs\": {\n" +
                "                            \"host\": {\n" +
                "                                \"connection\": {\n" +
                "                                    \"name\": \"@parameters('$connections')['Harmony-Salesloft']['connectionId']\"\n" +
                "                                }\n" +
                "                            },\n" +
                "                            \"method\": \"get\",\n" +
                "                            \"path\": \"/v2/bulk_jobs/@{encodeURIComponent(variables('jobId'))}\"\n" +
                "                        },\n" +
                "                        \"runAfter\": {},\n" +
                "                        \"type\": \"ApiConnection\"\n" +
                "                    },\n" +
                "                    \"Delay\": {\n" +
                "                        \"inputs\": {\n" +
                "                            \"interval\": {\n" +
                "                                \"count\": 30,\n" +
                "                                \"unit\": \"Second\"\n" +
                "                            }\n" +
                "                        },\n" +
                "                        \"runAfter\": {\n" +
                "                            \"Set_JobState_Status\": [\n" +
                "                                \"Succeeded\"\n" +
                "                            ]\n" +
                "                        },\n" +
                "                        \"type\": \"Wait\"\n" +
                "                    },\n" +
                "                    \"Set_JobState_Status\": {\n" +
                "                        \"inputs\": {\n" +
                "                            \"name\": \"Jobstate\",\n" +
                "                            \"value\": \"@{body('Bulk_Import_Status')['data']['state']}\"\n" +
                "                        },\n" +
                "                        \"runAfter\": {\n" +
                "                            \"Bulk_Import_Status\": [\n" +
                "                                \"Succeeded\"\n" +
                "                            ]\n" +
                "                        },\n" +
                "                        \"type\": \"SetVariable\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"expression\": \"@equals(variables('Jobstate'), 'done')\",\n" +
                "                \"limit\": {\n" +
                "                    \"count\": 60,\n" +
                "                    \"timeout\": \"PT24H\"\n" +
                "                },\n" +
                "                \"runAfter\": {\n" +
                "                    \"Set_JobState\": [\n" +
                "                        \"Succeeded\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"type\": \"Until\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"contentVersion\": \"1.0.0.0\",\n" +
                "        \"outputs\": {},\n" +
                "        \"parameters\": {\n" +
                "            \"$connections\": {\n" +
                "                \"defaultValue\": {},\n" +
                "                \"type\": \"Object\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"triggers\": {\n" +
                "            \"When_a_message_is_received_in_a_topic_subscription_(peek-lock)\": {\n" +
                "                \"inputs\": {\n" +
                "                    \"host\": {\n" +
                "                        \"connection\": {\n" +
                "                            \"name\": \"@parameters('$connections')['servicebus_1']['connectionId']\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"method\": \"get\",\n" +
                "                    \"path\": \"/@{encodeURIComponent(encodeURIComponent('tagee-salesloftlmstop'))}/subscriptions/@{encodeURIComponent('salesloftlmstopicsubscription')}/messages/head/peek\"\n" +
                "                },\n" +
                "                \"recurrence\": {\n" +
                "                    \"frequency\": \"Minute\",\n" +
                "                    \"interval\": 3\n" +
                "                },\n" +
                "                \"runtimeConfiguration\": {\n" +
                "                    \"concurrency\": {\n" +
                "                        \"runs\": 1\n" +
                "                    }\n" +
                "                },\n" +
                "                \"type\": \"ApiConnection\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"parameters\": {\n" +
                "        \"$connections\": {\n" +
                "            \"value\": {\n" +
                "                \"Harmony-Salesloft\": {\n" +
                "                    \"connectionId\": \"/subscriptions/71ab61f8-7681-4979-bcf4-1b21e1b0ea43/resourceGroups/wu2-dyn-sse-tagee-stg-rg/providers/Microsoft.Web/connections/Harmony-Salesloft\",\n" +
                "                    \"connectionName\": \"Harmony-Salesloft\",\n" +
                "                    \"id\": \"/subscriptions/71ab61f8-7681-4979-bcf4-1b21e1b0ea43/resourceGroups/wus2-epe-stg-swe-hmny-app-rg/providers/Microsoft.Web/customApis/Harmony-Salesloft\"\n" +
                "                },\n" +
                "                \"servicebus_1\": {\n" +
                "                    \"connectionId\": \"/subscriptions/71ab61f8-7681-4979-bcf4-1b21e1b0ea43/resourceGroups/wu2-dyn-sse-tagee-stg-rg/providers/Microsoft.Web/connections/servicebus\",\n" +
                "                    \"connectionName\": \"servicebus\",\n" +
                "                    \"id\": \"/subscriptions/71ab61f8-7681-4979-bcf4-1b21e1b0ea43/providers/Microsoft.Web/locations/westus2/managedApis/servicebus\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(strjson);
        JSONObject jsonObject = new JSONObject(strjson);
        JSONObject actionObj = null;

            actionObj = jsonObject.getJSONObject("definition").getJSONObject("actions");

            for (String key : actionObj.keySet()) {
                JSONObject actionElem = actionObj.getJSONObject(key);
                if (actionElem.getString("type").equalsIgnoreCase("http")) {
                    root = objectMapper.readTree(actionElem.toString());

                    System.out.println(root.at("/inputs/uri").asText());
                }
            }

    }
}
