# Testes de validação

Na pasta do projeto (a que contém `src`), execute no PowerShell com o JDK instalado:

```powershell
New-Item -ItemType Directory -Force out/testes | Out-Null
javac -encoding UTF-8 -d out/testes src/*.java tests/ValidacoesTest.java
if ($LASTEXITCODE -eq 0) { java -cp out/testes ValidacoesTest }
```

Os testes usam apenas Java e cobrem avaliações, durações e o total da maratona.
As verificações acumulam falhas e, se houver alguma, encerram com código diferente de zero.
