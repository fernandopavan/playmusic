echo "Executando o curl...";

curl -X POST \
  -H "Content-Type: multipart/form-data" \
  -F "file=@music.mp3" \
  http://localhost:8085/v1/customers/89eab3673-3c53-4251-b554-d38dc9395860/musics/f6ec8401-8b13-4871-b54c-7f1296d3b589

echo "\n";