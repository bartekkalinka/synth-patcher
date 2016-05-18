package pl.bka

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

