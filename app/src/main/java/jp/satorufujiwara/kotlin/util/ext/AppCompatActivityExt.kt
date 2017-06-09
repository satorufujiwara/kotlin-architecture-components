package jp.satorufujiwara.kotlin.util.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

inline fun FragmentActivity.setContentFragment(containerViewId: Int, f: () -> Fragment): Fragment? {
  val manager = supportFragmentManager
  val fragment = manager?.findFragmentById(containerViewId)
  fragment?.let { return it }
  return f().apply { manager?.beginTransaction()?.add(containerViewId, this)?.commit() }
}