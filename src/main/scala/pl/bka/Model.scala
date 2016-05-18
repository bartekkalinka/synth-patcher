package pl.bka

case class Socket(name: String, in: Boolean)

case class Module(name: String, sockets: Seq[Socket])

case class Synth(modules: Seq[Module])

case class Connection(from: Socket, to: Socket)

case class Patch(connections: Seq[Connection])
