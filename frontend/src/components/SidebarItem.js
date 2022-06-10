import React from "react";

function SidebarItem({ menu }) {
  console.log(menu);
  return (
    <div className="sidebar-item">
      <p>{menu.name}</p>
    </div>
  );
}

export default SidebarItem;