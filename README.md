# Rest-api-spring-boot
It is  a REST API project that will take a question via a URL Encoded GET parameter in the mentioned url endpoint and will respond to the answer in JSON format.
The bot is able to answer following questions:


1.Greetings

Corona is a polite alien. She can exchange some greetings. Don’t be rude to her.
Sample:
“Hello! How are you?”
“Hi! What is your name?”
“Good morning! I am Corona! It’s a pleasure to meet you!”
Her greeting messages will contain “Hi!”,”Hello!”,”Good morning/evening/night!” and you can tell
her anything according to your interest that starts with the term “Hello, Corona!”
Route: GET /greetings
Params: q=question (url encoded)
Example: /greetings?q=Hello!%20How%20are%20you?
Response: JSON
{
“answer”:”Hello, Corona! rest_of_your_answer”
}

2.Weather Info

Corona is curious about our planet’s weather. She may ask for general weather related
information for a city like - Current temperature, humidity, Weather Forecast of today.
Sample question:
“What is today’s temperature in <City Name (i.e. Dhaka/London)>?”
“What is today's humidity in <City Name>?”
“Is there Rain/Clouds/Clear weather today in <City Name>?”
Sample answer:
“24 C” or “297.15 K”
“15”
“Yes” / “No”
Route: GET /weather
Params: q=question (url encoded) i.e. ?q=anything from above
Response: JSON
{
“answer” : ”your answer”
}

3.Basic World Affairs

Queries on famous people, country, movies, books, music etc. You can get help from Wikipedia
or google to answer these questions.
Sample question:
“Who is the president of Bangladesh?”
“How old is Putin?” (in years)
“How long is the Titanic movie?” (in minute)
“What is the prime language of Bangladesh?”
“Who is the current CEO of Google?”
It is normal that you can’t build an Oracle over the night that knows everything. Just try to
answer Corona’s question. If you can’t answer something, tell her -
“Your majesty! Jon Snow knows nothing! So do I!”
Route: GET /qa
Params: q=question (url encoded)
Example: /qa?q=who+is+bill+gates%3F
Response: JSON
{
“answer” : ”your answer”
}
