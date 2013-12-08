package scoverage.report

import scoverage.MeasuredFile
import scala.xml.Node

/** @author Stephen Samuel */
class StatementWriter(mfile: MeasuredFile) {

  val GREEN = "#AEF1AE"
  val RED = "#F0ADAD"

  def output: Node = {

    def cellStyle(invoked: Boolean): String = invoked match {
      case true => s"background: $GREEN"
      case false => s"background: $RED"
    }


    <table cellspacing="0" cellpadding="0" class="table">
      {mfile.statements.map(stmt => {
      <tr>
        <td style={cellStyle(stmt.isInvoked)}>
          {stmt.source}
        </td>
      </tr>
    })}
    </table>
  }
}
