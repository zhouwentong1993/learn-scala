object NotificationMain {
  def main(args: Array[String]): Unit = {
    val email = Email("周文童", "测试 email", "email body")
    val sms = SMS("周文童", "测试 sms")
    println(showNotification(sms))
    println(showNotification(email))

  }

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) => s"You got an email from $sender with title: $title"
      case SMS(caller: String, message: String) => s"You got an SMS from $caller! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
}
