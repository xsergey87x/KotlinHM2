fun main() {
    val i = numJewelsInStones("zZ", "asdzzZS")
    println(i.toString());

    val k = judgeCircle("DDUULLRR")
    println(k.toString())

    val data = arrayListOf<String>(
        "fdsfaaaa...dsfd@ukr.net", "fdbbb+sfsd+f...sfd@u.k.r.net",
        "fdbbsfd@u.k.r.net", "fdbbsfd@ukr.net"
    )
    val l = numUniqueEmails(data);
    println(l.toString())
}

fun numJewelsInStones(jewels: String, stones: String): Int {

    var im = 0;

    for (i in 1..jewels.length) {
        for (k in 1..stones.length) {
            if (stones[k - 1] == jewels[i - 1]) {
                im++
            }
        }
    }

    return im;
}

fun judgeCircle(moves: String): Boolean {
    var result = false;
    var l = 0
    var m = 0

    for (i in 1..moves.length) {
        when (moves[i - 1]) {
            'R' -> m++
            'L' -> m--
            'U' -> l++
            'D' -> l--
        }
    }

    result = l + m == 0

    return result;
}

fun numUniqueEmails(emails: ArrayList<String>): Int {
    val emailsList: MutableList<String> = emails.toMutableList()
    val resultList: MutableSet<String> = emails.toMutableSet()
    resultList.clear()
    lateinit var temp: String

    emailsList.forEach {
        temp = it.substringBefore("+") + "@" + it.substringAfterLast("@")
        temp = temp.substringBefore("@").replace(".", "") + "@" + it.substringAfterLast("@")
        resultList.add(temp)
    }

    return resultList.size
}