# Testes de validação

Na pasta do projeto (a que contém `src`), execute no PowerShell com o JDK instalado:

```powershell
New-Item -ItemType Directory -Force out/testes | Out-Null
$arquivos = Get-ChildItem src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -d out/testes @arquivos tests/ValidacoesTest.java
if ($LASTEXITCODE -eq 0) { java -cp out/testes ValidacoesTest }
```

Os testes usam apenas Java e cobrem avaliações, durações, o total da maratona,
as recomendações e os valores de episódios e visualizações.
As verificações acumulam falhas e, se houver alguma, encerram com código diferente de zero.
