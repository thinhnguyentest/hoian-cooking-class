# Hoian Cooking Class - Backend Architecture & Implementation Plan (Updated)

Bản kế hoạch này đã được tinh chỉnh để đơn giản hóa cấu trúc dữ liệu, tối ưu cho việc quản lý nội dung động và sẵn sàng cho hệ thống User sau này.

---

## 1. Hệ thống Module & Cơ sở dữ liệu

---

### Module 1: Content Management (Dynamic Content)

#### Bảng `page_types`
*   `id`, `name`, `code`, `description`
*   **Seeding**: `COOKING_CLASS`, `FOOD_TOUR`, `MAKING_LANTERN`, `MAKING_COFFEE`.

#### Bảng `pages`
*   **Cấu trúc**: `id`, `page_type_id`, `title`, `description`, `slug`.
*   **Dữ liệu Seeding (4 trang chính)**:
    1.  `cooking-class` (Slug: `/`)
    2.  `food-tour` (Slug: `/food-tour`)
    3.  `making-coffee` (Slug: `/making-coffee-class`)
    4.  `making-lantern` (Slug: `/making-lantern`)

#### Bảng `page_contents` (Renamed from itineraries)
*   **Mục đích**: Lưu các mục nhỏ trong tour/lớp học (vd: tên món ăn).
*   **Cấu trúc**: `id`, `page_id`, `title`, `description`, `effectiveDate`.

#### Bảng `menus` 
*   **Mục đích**: Lưu các mục nhỏ trong tour/lớp học (vd: tên món ăn).
*   **Cấu trúc**: `id`, `page_id`, `title`, `description`, `effectiveDate`.

#### Bảng `images` (Renamed from media_assets)
*   **Mục đích**: Quản lý tất cả ảnh trên hệ thống (Hero, Gallery, Review, Content).
*   **Cấu trúc**: `id`, `page_id`, `url` (Cloudinary URL), `source_type` (vd: `HERO`, `CAROUSEL`, `CONTENT`, `REVIEW`).

---

### Module 2: Social & Operations

#### Bảng `reviews`
*   **Cấu trúc**: `id`, `page_id`, `user_id` (userId), `rating`, `comment`, `is_published`.
*   **Lưu ý**: `user_id` có thể join với bảng `users`.

#### Bảng `bookings`
*   **Cấu trúc**: `id`, `page_id`, `user_id` (có thể null), `email`, `phone`, `booking_date`, `pax`, `status`.

#### Bảng `site_configs`
*   **Cấu trúc**: `key`, `value` (vd: `whatsapp_link`, `zalo_link`, `office_address`).

---

### Module 3: System & Security Management
người dùng và bảo mật JWT.

#### Bảng `users`
*   **Cấu trúc**: `id`, `email`, `password`, `full_name`, `phone`, `status`, `is_deleted`.

#### Bảng `roles` (New)
*   **Cấu trúc**: `id`, `name` (vd: `ROLE_ADMIN`, `ROLE_USER`).

#### Bảng `user_roles` (New)
*   **Mục đích**: Liên kết n-n giữa User và Role.
*   **Cấu trúc**: `user_id`, `role_id`.

#### Bảng `refresh_tokens` (New)
*   **Mục đích**: Quản lý phiên đăng nhập JWT (Refresh Token).
*   **Cấu trúc**: `id`, `user_id`, `token`, `expiry_date`.

---

