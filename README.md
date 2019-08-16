# Short Url

## Config PostgreSQL
bd: shorturl <br>
usuario: shorturl <br>
senha: shorturl

## Endpoint

1. Criar link encurtado  <br>
  Post -> http://localhost:8080/shorturl <br>
  Body -> { "urlOriginal":"https://google.com.br/"}  <br>

2. Abrir o link <br>
  Get -> http://localhost:8080/shorturl/14f30b6 <br>
  
3. Estatística <br>
  http://localhost:8080/shorturl/14f30b6/statistic <br>
