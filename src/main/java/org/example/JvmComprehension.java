package org.example;

public class JvmComprehension {
    public static void main(String[] args) {
        int i = 1;                      // 1 Ссылка на int i = 1 добавляется в стек JvmComprehension
        Object o = new Object();        // 2 Object o добавляется в heap, ссылка в стэк
        Integer ii = 2;                 // 3 В стэк добавляется сслыка на Integer ii = 2
        printAll(o, i, ii);             // 4 В стэк добавляется ссылка на printAll(o, i, ii) - cвязываются с кучей
        System.out.println("finished"); // 7 В стэк создается фрейм с ссылкой на finished
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В стэк добавляется ссылка на uselessVar = 700 связанный с кучей Integer
        System.out.println(o.toString() + i + ii);  // 6 В стэк создается фрейм с ссылкой o.toString(), i, ii.
    }
}
// 1. public static void main(String[] args) - Загрузчик классов ClassLoader загружает class-файлы JvmComprehension и System.out.println()
// 2. Bootstrap class loader (базовый, первичный загрузчик) — загружает классы из bootstrap classpath.
// 3. Связывание, линковка (linking) — выполнение верификации(Verify), подготовки(Prepare) и, необязательного, разрешения(Resolve)
// 4. Инициализация (initialization)
// 5. Выполняются инициализатор static printAll()
// 6. Как только мы вызываем метод main, в стеке JvmComprehension для нее создается стековый кадр(stack frame), пустая куча(heap)c Metaspace


//JVM находятся в оперативной памяти. Во время выполнения с помощью загрузчика классов файлы классов
// заносятся в ОЗУ. Код BYTE проверяется на любые нарушения безопасности.
// Затем механизм выполнения преобразует Байт-код в машинный код Native.
// В этом участвует и JIT. Он интерпретирует часть Байт-кода, который имеет аналогичные функции одновременно.
// Параллельно с этим работает Garbage Collection который собирает больше не используемые объекты из heap(кучи).

