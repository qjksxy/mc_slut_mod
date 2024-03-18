# MSM: MC_SLUT_MOD
MC Fabric Mod: Shuangliao University of Technology

**此项目已经搁置，预计未来创建新项目代替当前项目**

文档创建时间：2023.01.18

最后编辑时间：2023.01.19

当前版本：0.4.2R

## 摘要
目前没有什么想法，首先要加入一些经典元素，比如---

其次加入一些学术相关内容，如论文一类

但是对于这些内容的具体功能表现怎么设计，还没有头绪

大家有想法可以提 `issue`，或者直接在群里说

**关键词:** 双辽理工; MC; Fabric; mod

# 正文

## 项目相关

### 更新日志
更多更新日志请见：
[MSM 更新日志](https://github.com/qjksxy/mc_slut_mod/blob/master/MSM_Update_Log.md)

**0.4.2**
- 降低了武器 `护摩之杖` 的攻击速度和附魔等级
- 提高了食物 `健哥`、`健哥（被烤了` 的饥饿值和饱食度
- 提高了食物 `健哥` 的堆肥成功概率

**0.4.1**
- 添加物品组

**0.4:**
- 添加武器 `护摩之杖`

### 设计文档
为保证本项目风格统一协调，开发时参考此设计文档：
[MSM 设计文档](https://github.com/qjksxy/mc_slut_mod/blob/master/MSM_Design_Document.md)

### 版本号说明
版本号由四部分构成：`主版本号.子版本号.阶段版本号.分支版本号` 。

- 主版本号在大规模功能变动或者不兼容更新时增长；
- 子版本号在功能变动时增长；
- 阶段版本号在非功能变动的情况下修改代码时增长；
- 分支版本号用于分支内版本标识，通常为分支功能名加序号。`master` 分支无分支版本号。

不更改代码的修改不变动版本号。若在版本号后附加 `R` 标识，说明当前版本为功能完善、
可以使用的稳定版本，该标识只用于 `master` 分支版本。

### 分支说明
应保证 `master` 分支内每一个版本都是成熟可用的版本，所有开发工作在分支内完成，
将成熟版本推送到 `master` 分支。

## 基本设定
双辽理工大学的学者们身处 MC 世界，但仍然保持着对于学术的热衷。在不知多久的刻苦钻研之后，
亦有许多成果问世。

## 模组内容
Version: 0.4.2R

**物品-青金碎末：**

- 获得方式：使用 `小麦`、`胡萝卜`、`马铃薯`、`甜菜根`、`青金石` 无序合成
- 用途：合成 `健哥`

*「沙城的学者们自青石中提取改良作物的碎屑，*

*并将这第一次培育新生的至上荣耀献给校长」*

**食物-健哥**

- 获得方式：使用 `马铃薯`、`青金碎末` 无序合成
- 用途：食用、堆肥、加工为 `健哥（被烤了`
- 食用：恢复 6 饥饿值，9.6 饱和度
- 堆肥：有0.8概率成功堆肥一层

**食物-健哥（被烤了**

- 获得方式：使用 `熔炉`、`烟熏炉` 或 `篝火` 烹饪 `健哥`
- 用途：食用、堆肥
- 食用：恢复 8 饥饿值，16 饱和度
- 堆肥：堆肥一层

**武器-护摩之杖**

- 获得方式：使用 `红石块` 和 `黑曜石` 有序合成，配方为：

  | 配方 |  |  |
  |:----:|:-----:|:-----:|
  | 红石块  |  红石块  |   无   |
  | 红石块  |  黑曜石  |   无   |
  |  无   |   无   |  黑曜石  |

- 用途：武器，伤害9，攻速2，耐久200，可以使用红石粉修复
- 武器技能：右键使用技能后玩家受到6点穿透伤害，同时获得400刻1级力量状态
- 攻击效果：攻击后，若玩家处于力量状态下，会获得如下状态：
  - 生命恢复 1级 50刻
  - 生命提升 1级 50刻

## 安装与使用
下载 [最新发行版](https://github.com/qjksxy/mc_slut_mod/releases/latest) 或 [历史版本](https://github.com/qjksxy/mc_slut_mod/releases)。

# 致谢

感谢 [@LiSoulSpace](https://github.com/LiSoulSpace) 提供服务器并为本项目贡献了部分代码。
