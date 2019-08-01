## Parking Lot

### 停车
Given 一个有空位的停车场和一辆车要停的车

When 这辆车停车

Then 返回"停车成功"

---

Given 一个没有空位的停车场和一辆车要停的车

When 这辆车停车

Then 返回"停车失败"

### 取车
Given 一辆车已停在停车场的车

When 这辆车取车

Then 返回"取车成功"

---

Given 一辆未停的车

When 这辆车取车

Then 返回“取车失败”

### 动态场景

Given 一个容量为 1 的停车场

When 停一辆车，取一辆车，再停一辆车

Then 返回写着“停车成功的”停车收据

---

Given 一个容量为 2 的停车场，且有一辆别的车在停车场里

When 停一辆车

Then 返回刚才停的车

## Graduate Parking Boy
作为一个初入职场的停车小弟，我能够将车**顺序停放到多个**停车场，并可以取出

### 小弟管理一个停车场
Given 一个停车小弟 AND 一个容量为 1 的空停车场 AND 一辆车

When 小弟停车

Then 返回停车收据

---

Given 一个停车小弟 AND 一个容量为 1 的满停车场 AND 一辆车

When 小弟停车

Then 返回空

---

Given 一个停车小弟 AND 停有一辆车的停车场 AND 该车的收据

When 小弟取车

Then 返回该车

---

Given 一个停车小弟 AND 停有一辆车的停车场 AND 其他收据

When 小弟取车

Then 返回空

### 小弟管理两个停车场

Given 一个停车小弟 
    AND 一个容量为 1 的满停车场
    AND 一个容量为 1 的空停车场 AND 一辆车

When 小弟停车

Then 返回收据

---

Given 一个停车小弟 AND 两个容量为 1 的满停车场 AND 一辆车

When 小弟停车

Then 返回空收据

---

Given 容量为 1 的满停车场（PL1）
    AND 容量为 1 的停车场（PL2）
    AND 容量为 1 的停车场（PL3）
    AND 停车小弟 (V1) 管理 PL1，PL2，PL3
    AND 停车小弟 （V2）管理 PL2
    AND 两辆车

When 停车小弟 V1 先停车，然后停车小弟 V2 停车

Then 停车小弟 V1 停车成功，返回收据，停车小弟 V2 停车失败，返回空收据

---

Given 一个停车小弟 
    AND 一个容量为 1 的满停车场(PL1)
    AND 一个容量为 1 的满停车场 (PL2)
    AND 一个停车小弟

When 停车小弟去取车

Then 返回那辆车

---

Given 一个停车小弟 
    AND 一个容量为 1 的满停车场和一个容量为 1 的空满停车场 
    AND 一个其他收据

When 小弟取车

Then 返回null

