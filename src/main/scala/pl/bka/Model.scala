package pl.bka

import scala.util.Random

case class Socket(name: String, in: Boolean)

case class Module(name: String, sockets: Seq[Socket])

case class Synth(modules: Seq[Module]) {
  val allSockets: Seq[Socket] = modules.flatMap(_.sockets)

  def randomConnection: Connection = {
    def randomSocket: Socket = allSockets(Random.nextInt(allSockets.length))
    Connection(randomSocket, randomSocket)
  }
}

case class Connection(from: Socket, to: Socket)

case class Patch(connections: Seq[Connection], output: Socket)

object Example {
  val synth = Synth(
    List(
      Module("miniosc", List(
        Socket("sine", false),
        Socket("square", false),
        Socket("1v/oct", true)
      )),
      Module("simplefilter", List(
        Socket("input", true),
        Socket("output", false)
      ))
    )
  )
}