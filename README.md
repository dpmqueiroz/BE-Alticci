# BE-Alticci

O projeto foi desenvolvido com o intuito de utilizar o serviço de Cache do Spring para Calcular o valor da sequencia Alticci.

A sequencia Alticci funciona com a seguinte formula:

n=0 => a(0) = 0 <br>
n=1 => a(1) = 1 <br>
n=2 => a(2) = 1 <br>
n>2 => a(n) = a(n-3) + a(n-2) <br>

## Para rodar o projeto na sua máquina siga o passo a passo.

1º Passo -> Clonar o repositório.

https://github.com/dpmqueiroz/BE-Alticci

2º Passo -> Verificar as variáveis de ambiente relacionado ao Maven e ao Java ( Aqui no momento da criação utilizei JDK 17.0.1 e Maven 3.9.1).

3º Passo -> Abrir o Terminal entrar na pasta raiz do projeto e executar o seguinte comando:

(`mvn spring-boot:run `)

Com a aplicação em execução temos dois links utéis:

1 - Documentação Swagger ->  http://localhost:8080/swagger-ui/index.html
2  -  Front End com Explicação ->    https://github.com/dpmqueiroz/FE-Alticci
