# DSCommerce

[![NPM](https://img.shields.io/npm/l/react)]( https://github.com/Hfictus/dscommerce/blob/main/LICENSE)

## Sobre o projeto:
DSCommerce, criada no contexto do curso Java Spring Professional da DevSuperior, é uma aplicação back-end web que tem em seu escopo controle de acesso com autenticação e autorização.<br>
O projeto, de loja online, passou pelas etapas de teste e homologação local, bem como de implantação, estando disponível em produção.<br>
Em DSCommerce, há três níveis de acesso que vão do público, sem necessidade de login, até aqueles vinculados aos perfis client e admin.<br>

## Tecnologias utilizadas:
Java;<br>
Spring Boot;<br>
JPA/Hibernate;<br>
Maven.<br>
<br>
## Implantação em produção:
Back-end: Railway;<br>
Banco de dados: Postgresql.<br>
<br>

## Layout Web:
a ser acrescentado...<br>
<br>

## Layout Mobile:
a ser acrescentado...<br>
<br>

## Modelos de domínio:
![Web 1]( https://github.com/Hfictus/images/blob/main/ModelDomainDSCommerce.png)
<br>
## User - Role:
![Web 1]( https://github.com/Hfictus/images/blob/main/ModelDomainUserRolesDSCommerce.png)
<br>

## Para testes:
Perfis de exemplos com login efetuado:<br>
maria: CLIENT.<br>
alex: CLIENT e ADMIN.<br>
Senha usada para os usuários: 123456. <br>
<br>
### Acesso direto à aplicação em produção (host):
Página padrão do Spring:<br>
https://dscommerce-production-8ddd.up.railway.app
### Dados de endpoints públicos
host/categories  (lista de categorias)<br>
host/products     (produtos do sistema)<br>
host/products/1  (busca de produto por id)<br>
<br>
## Instruções para testes de homologação e produção:
### Homologação:
Clonar o repositório dscommerce; ou, fazer o download do arquivo .zip.<br>
### Para clonar repositório:
```bash
git clone git@github.com:Hfictus/dscommerce.git
```

### Perfis de test e dev:
Configurar perfil de test ou dev em application.properties, na variável APP_PROFILE.<br>
Para APP_PROFILE:test:<br>
Acesso ao banco de dados H2 com a aplicação executando na IDE:<br>
http://localhost:8080/h2-console<br>
As tabelas acessadas pelo H2 são automaticamente geradas por meio de ORM e o seed é efetuado a partir do arquivo iimport.sql.<br>
Para testes com o Postman, ver a partir do tópico “Testes de requisição no Postman”.<br>
<br>
### Para APP_PROFILE:dev:
Usar PostgreSQL com PgAdmin (ou DBeaver), criando base de dados.<br>
PgAdmin > Server > Databases > dscommerce > Tables (botão direito do mouse > Query Tool).<br>
Executar script contido em created.sql para criar tabelas e fazer o seed no banco de dados PostgreSQL pelo PgAdmin.<br>
Tables (botão direito do mouse > Refresh).<br>
<br>
Testes de requisição no Postman:
Importar coleção de requisições:
File > Import > Files > collection-postman-tests.json
<br>

### Variáveis de ambiente para perfis de teste e homologação (test, dev):
. host: <br> http://localhost:8080<br>
. cliente-id: <br> myclientid<br>
. client-secret: <br> myclientsecret<br>
. username: <br> maria@gmail.com / alex@gmail.com<br>
. password: <br> 123456<br>
. token: <br>
token a ser gerado na requisição de login<br>
<br>

### Host para testes com perfil prod (produção: link para demo da aplicação):
. host                 | https://dscommerce-production-8ddd.up.railway.app<br>
<br>

### Instruções para testes no Postman:
Recomenda-se começar os testes pelo usuário maria@gmail.com, seguindo-se a ordem indicada abaixo.<br>
<br>

### Acessos permitidos ao usuário anônimo (requisições públicas):
. username: maria@gmail.com<br>
GET  | Categories (lista de categorias)<br>
GET  | products (lista paginada de produtos)<br>
GET  | productbyid (busca de produto por id)<br>
Obs.: se qualquer usuário anônimo tentar realizar requisição para a qual não tem autorização, há o retorno do código 401, indicando que o login não foi efetuado.<br>
<br>

### Acessos permitidos ao usuário com perfil CLIENT (login ok):
POST | Login (efetuar login)<br>
GET   | User logged (busca dados do usuário com login efetuado)<br>
GET   | Orderbyid (para pedidos feitos pelo próprio cliente)<br>
POST | New order<br>
<br>

### Acessos negados ao cliente (código 403):
GET   | Orderbyid (para pedidos que são de outros clientes)<br>
PUT   | product (atualiza dados de um produto buscado pelo id)<br> 
POST  | newproduct (adiciona um novo produto ao sistema)<br>
DEL   | productbyid (exclui um produto do sistema a partir do id)<br>
<br>

### Acessos permitidos ao usuário com perfil ADMIN (login ok):
. username: alex@gmail.com<br>
POST | Login (efetuar login)<br>
Acesso a todas as requisições apresentadas.<br>
<br>

Além das exceções 401 e 403, há a 422 para os casos de tentativa de atualização ou criação de um produto que tenha valores não positivos para “price”, e “name” vazio ou com menos de 3 e mais de 80 caracteres.<br>

## Autor:<br>
Gerson Klauck (Hfictus)
