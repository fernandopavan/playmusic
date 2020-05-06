echo "Executando o curl...";

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{ "name": "Musica 5", "uuidCustomer": "9eab3673-3c53-4251-b554-d38dc9395860"}' \
  http://localhost:8082/v1/customers/9eab3673-3c53-4251-b554-d38dc9395860/musics

echo "\n";