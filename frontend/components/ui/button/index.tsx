/** @jsxImportSource @emotion/react */
"use client";

import { css } from "@emotion/react";

export default function ButtonIcon({
  children,
  color,
  bgColor,
  onClick,
}: {
  children: React.ReactNode;
  color?: string;
  bgColor?: string;
  onClick?: () => void;
}) {
  const buttonStyle = css`
    background-color: ${bgColor};
    color: ${color};
    border: none;
    border-radius: 1.2rem;
    padding: 0.4rem 0.6rem;
    font-size: 1.4rem;
    display: flex;
    align-items: center;
  `;

  return (
    <button css={buttonStyle} onClick={onClick}>
      {children}
    </button>
  );
}
