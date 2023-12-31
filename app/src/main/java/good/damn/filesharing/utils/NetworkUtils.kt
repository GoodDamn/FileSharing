package good.damn.filesharing.utils

import java.io.ByteArrayOutputStream
import java.io.InputStream

class NetworkUtils {
    companion object {

        fun readBytes(
            inp: InputStream
        ): ByteArray {
            return readBytes(inp, ByteArray(8192))
        }

        fun readBytes(
            inp: InputStream,
            buffer: ByteArray
        ): ByteArray {

            val outArr = ByteArrayOutputStream()

            var n: Int

            while (true) {
                n = inp.read(buffer)
                if (n == -1) {
                    break
                }
                outArr.write(buffer,0,n)
            }

            val data = outArr.toByteArray()
            outArr.close()

            return data
        }

    }
}