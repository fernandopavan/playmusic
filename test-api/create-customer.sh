echo "Executando o curl...";

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{ "name": "Nome 1", "country": "BR",  "musicStyle": "rock"}' \
  http://localhost:8080/v1/

echo "\n";