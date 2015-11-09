Aplikácia je vyvíjaná pre operačý systém Windows, pre spustenie aplikácie pomocou nástroja Maven spustite v konzole
najprv príkaz:"mvn package"
a potom môžete spustiť aplikáciu
príkazom z konzoly:"java -cp target/bsc-1.0-SNAPSHOT.jar com.bsc.main.Starter"

Po štarte používateľ môže zadať, či si praje načítať súbor s dátami, alebo nie. Ak zvolí nesprávnu voľbu, alebo súbor
sa nenájde, program predpokladá, že sa ďalej nebude používať súbor s dátami.
Po načítaní/nenačítaní súboru program začne vypisovať transakcie (ak existujú) a vyzve používateľa na zadávanie
príkazov vo formáte MENA ČIASTKA
V prípade chybného vstupu od používateľa sa program ukončí.







